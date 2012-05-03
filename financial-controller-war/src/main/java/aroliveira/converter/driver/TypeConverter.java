package aroliveira.converter.driver;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import aroliveira.lab.structure.util.Type;

@FacesConverter(forClass=aroliveira.lab.structure.util.Type.class)
public class TypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String textType) {
		return Type.valueOf(textType);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object type) {
		return type.toString();
	}
}
