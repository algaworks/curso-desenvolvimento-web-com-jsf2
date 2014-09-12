package com.algaworks.cursojsf2.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.algaworks.cursojsf2.financeiro.util.FacesUtil;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.algaworks.Comprovante")
public class ComprovanteValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		Part arquivo = (Part) value;
		
		if (arquivo != null && !"application/pdf".equals(arquivo.getContentType())) {
			Object label = MessageFactory.getLabel(context, component);
			
			String descricaoErro = label + " " + FacesUtil.getMensagemI18n("is_not_a_proper_file");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					descricaoErro, descricaoErro);
			throw new ValidatorException(message);
		}
	}

}