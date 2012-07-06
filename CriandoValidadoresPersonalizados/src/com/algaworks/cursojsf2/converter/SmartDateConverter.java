package com.algaworks.cursojsf2.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.algaworks.SmartDate")
public class SmartDateConverter implements Converter {

	private static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date getDataHoje() {
		Calendar dataHoje = Calendar.getInstance();
		dataHoje.set(Calendar.HOUR_OF_DAY, 0);
		dataHoje.set(Calendar.MINUTE, 0);
		dataHoje.set(Calendar.SECOND, 0);
		dataHoje.set(Calendar.MILLISECOND, 0);
		return dataHoje.getTime();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Date dataConvertida = null;
		
		if (value != null && !value.equals("")) {
			if (value.equalsIgnoreCase("hoje")) {
				dataConvertida = getDataHoje();
			} else {
				try {
					dataConvertida = formatador.parse(value);
				} catch (ParseException e) {
					FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Data incorreta.", "Informe uma data correta.");
					throw new ConverterException(msg);
				}
			}
		}
		
		return dataConvertida;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (this.getDataHoje().equals(value)) {
			return "hoje";
		}
		return formatador.format((Date) value);
	}

}