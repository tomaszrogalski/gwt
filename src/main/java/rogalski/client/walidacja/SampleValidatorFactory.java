package rogalski.client.walidacja;

import javax.validation.Validator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

import rogalski.shared.dto.AdresDTO;
import rogalski.shared.dto.KlientDTO;
import rogalski.shared.dto.PozycjaDTO;
import rogalski.shared.dto.ProduktDTO;
import rogalski.shared.dto.UslugaDTO;

public final class SampleValidatorFactory extends AbstractGwtValidatorFactory {

	@GwtValidation(value = { KlientDTO.class, AdresDTO.class, PozycjaDTO.class, UslugaDTO.class, ProduktDTO.class })
	public interface GwtValidator extends Validator {

	}

	@Override
	public AbstractGwtValidator createValidator() {
		return GWT.create(GwtValidator.class);
	}

}