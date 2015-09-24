package rogalski.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import rogalski.server.model.Klient;
import rogalski.shared.dto.KlientDTO;

@Stateless

public class KlientDAO {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworzKlienta(Klient klient) {
		entityManager.merge(klient);
	}

	public List<KlientDTO> wczytajWszystkichKlientow() {

		List<KlientDTO> listaKlientowDTO = new ArrayList<>();
		Query query = entityManager.createQuery("FROM Klient");
		List<Klient> listaKlientow = query.getResultList();

		for (Klient klient : listaKlientow) {
			listaKlientowDTO.add(klient.stworzKlientaDTO());
		}
		return listaKlientowDTO;
	}
	

public KlientDTO wczytajOstatnioDodanego() {
		KlientDTO klientDTO = null;
		Klient klient = null;
		Query query = entityManager.createQuery(
				"Select OBJECT(klient) FROM Klient klient where klient.id=(select max(klient2.id) from Klient klient2)");
		klient = (Klient) query.getSingleResult();
		klientDTO = klient.stworzKlientaDTO();
		return klientDTO;
	}

}