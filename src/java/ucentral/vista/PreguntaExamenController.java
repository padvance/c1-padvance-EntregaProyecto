package ucentral.vista;

import ucentral.modelo.PreguntaExamen;
import ucentral.vista.util.JsfUtil;
import ucentral.vista.util.JsfUtil.PersistAction;
import ucentral.controlador.PreguntaExamenFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ucentral.modelo.Examen;

@ManagedBean(name = "preguntaExamenController")
@SessionScoped
public class PreguntaExamenController implements Serializable {

    @EJB
    private ucentral.controlador.PreguntaExamenFacade ejbFacade;
    private List<PreguntaExamen> items = null;
    private PreguntaExamen selected;
    private Examen examen;

    public PreguntaExamenController() {
    }

    public PreguntaExamen getSelected() {
        return selected;
    }

    public void setSelected(PreguntaExamen selected) {
        this.selected = selected;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PreguntaExamenFacade getFacade() {
        return ejbFacade;
    }

    public PreguntaExamen prepareCreate() {
        selected = new PreguntaExamen();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PreguntaExamenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PreguntaExamenUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PreguntaExamenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PreguntaExamen> getItems() {
        if (examen != null){
            items = getFacade().findByExamen(examen);
            if (items.size()>2){
                List<PreguntaExamen> nItems = new Stack<>();
                for (int i = 0; i < 2; i++){
                    double val = Math.random();
                    if(val * 2 < items.size()){
                        nItems.add(items.get((int) (val * 2)));                        
                    }
                    if (nItems.size()<2 && i == 1){
                        i--;
                    }
                }
                items = nItems;
            }
        }else if (items == null) {            
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<PreguntaExamen> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PreguntaExamen> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PreguntaExamen.class)
    public static class PreguntaExamenControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PreguntaExamenController controller = (PreguntaExamenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "preguntaExamenController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PreguntaExamen) {
                PreguntaExamen o = (PreguntaExamen) object;
                return getStringKey(o.getIdExampreg());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PreguntaExamen.class.getName()});
                return null;
            }
        }

    }

}
