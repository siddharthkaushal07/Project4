package in.co.rays.project_4.util;

import java.util.Collections;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import in.co.rays.project_4.bean.DropdownListBean;
import in.co.rays.project_4.model.BaseModel;

/**
 * The Class HTMLUtility.
 */
public class HTMLUtility {
	
	/**
	 * Create HTML SELECT list from MAP paramters values.
	 *
	 * @param name the name
	 * @param selectedVal the selected val
	 * @param map the map
	 * @return the list
	 */

    public static String getList(String name, String selectedVal,
            HashMap<String, String> map) {

        StringBuffer sb = new StringBuffer(
        		/*"<select style='height: 20px; border-style:groove; width: 173px;'class= 'form-control' name='" + name + "'>"*/
        		"<select style='height: 20px; border-style:groove; width: 173px; font-size: 1em;' name='" + name + "'>");
     //   sb.append("<option selected value>--------select---------</option>");
                //"<select class='form-control' name='" + name + "'>");

        Set<String> keys = map.keySet();
        String val = null;
        String select="-----------Select -------------";
        sb.append("<option selected value>--------select---------</option>");
        for (String key : keys) {
            val = map.get(key);
            if (key.trim().equals(selectedVal)) {
                sb.append("<option selected value='" + key + "'>" + val
                        + "</option>");
            } else {
                sb.append("<option value='" + key + "'>" + val + "</option>");
            }
        }
        sb.append("</select>");
        return sb.toString();
    }

    /**
     * Create HTML SELECT List from List parameter.
     *
     * @param name the name
     * @param selectedVal the selected val
     * @param list the list
     * @return the list
     */
    public static String getList(String name, String selectedVal, List list) {

        Collections.sort(list);

        List<DropdownListBean> dd = (List<DropdownListBean>) list;

        StringBuffer sb = new StringBuffer(
        		/*"<select style='width:160px;hight:24px;class='form-control' name='" + name + "'>"
        +"<option disabled selected value>--------select---------</option>"*/
        		"<select class='form-control' style='height: 20px; border-style:groove; width: 173px; font-size: 1em;' name='" + name + "'>");

        		
        String key = null;
        String val = null;

        String select="-----------Select-----------";
        sb.append("<option selected value=' '>" +select+ "</option>");
        System.out.println("selected value"+selectedVal);
        for (DropdownListBean obj : dd) {
            key = obj.getKey();
            val = obj.getValue();

            if (key.trim().equals(selectedVal)) {
                sb.append("<option selected value='" + key + "'>" + val
                        + "</option>");
            } else {
                sb.append("<option value='" + key + "'>" + val + "</option>");
            }
        }
        sb.append("</select>");
        return sb.toString();
    }

    /**
     * Gets the list.
     *
     * @param name the name
     * @param selectedVal the selected val
     * @param map the map
     * @param select the select
     * @return the list
     */
    public static String getList(String name, String selectedVal,
            HashMap<String, String> map, boolean select) {

        StringBuffer sb = new StringBuffer(
        		"<select class='form-control' name='" + name + "'>");

        Set<String> keys = map.keySet();
        String val = null;

        if (select) {

            sb.append("<option selected value=''> --Select-- </option>");
        }

        for (String key : keys) {
            val = map.get(key);
            if (key.trim().equals(selectedVal)) {
                sb.append("<option selected value='" + key + "'>" + val
                        + "</option>");
            } else {
                sb.append("<option value='" + key + "'>" + val + "</option>");
            }
        }
        sb.append("</select>");
        return sb.toString();
    }

    /**
     * Gets the input error messages.
     *
     * @param request the request
     * @return the input error messages
     */
    public static String getInputErrorMessages(HttpServletRequest request) {

        Enumeration<String> e = request.getAttributeNames();

        StringBuffer sb = new StringBuffer("<UL>");
        String name = null;

        while (e.hasMoreElements()) {
            name = e.nextElement();
            if (name.startsWith("error.")) {
                sb.append("<LI class='error'>" + request.getAttribute(name)
                        + "</LI>");
            }
        }
        sb.append("</UL>");
        return sb.toString();
    }

    /**
     * Returns Error Message with HTML tag and CSS.
     *
     * @param request the request
     * @return the error message
     */
    public static String getErrorMessage(HttpServletRequest request) {
        String msg = ServletUtility.getErrorMessage(request);
        if (!DataValidator.isNull(msg)) {
            msg = "<p class='st-error-header'>" + msg + "</p>";
        }
        return msg;
    }

    /**
     * Returns Success Message with HTML tag and CSS.
     *
     * @param request the request
     * @return the success message
     */

    public static String getSuccessMessage(HttpServletRequest request) {
        String msg = ServletUtility.getSuccessMessage(request);
        if (!DataValidator.isNull(msg)) {
            msg = "<p class='st-success-header'>" + msg + "</p>";
        }
        return msg;
    }

    /**
     * Creates submit button if user has access permission.
     *
     * @param label the label
     * @param access the access
     * @param request the request
     * @return the submit button
     */
    public static String getSubmitButton(String label, boolean access,
            HttpServletRequest request) {

        String button = "";

        if (access) {
            button = "<input type='submit' name='operation'    value='" + label
                    + "' >";
        }
        return button;
    }

    /**
     * Gets the common fields.
     *
     * @param request the request
     * @return the common fields
     */
    public static String getCommonFields(HttpServletRequest request) {

        BaseModel model = ServletUtility.getModel(request);

        StringBuffer sb = new StringBuffer();

        sb.append("<input type='hidden' name='id' value=" + model.getId() + ">");
        /*
         * sb.append("<input type='hidden' name='createdBy' value=" +
         * DataUtility.getString(model.getCreatedBy()) + ">");
         * sb.append("<input type='hidden' name='modifiedBy' value=" +
         * DataUtility.getString(model.getModifiedBy()) + ">");
         * sb.append("<input type='hidden' name='createdDatetime' value=" +
         * DataUtility.getTimestamp(model.getCreatedDatetime()) + ">");
         * sb.append("<input type='hidden' name='modifiedDatetime' value=" +
         * DataUtility.getTimestamp(model.getModifiedDatetime()) + ">");
         */
        return sb.toString();
    }


}
