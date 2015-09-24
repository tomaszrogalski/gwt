package rogalski.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Fakturowanie.server.model.Faktura;
import Fakturowanie.server.model.Pozycja;
import Fakturowanie.server.model.Produkt;
import Fakturowanie.server.model.Usluga;
import Fakturowanie.shared.dto.FakturaDTO;
import Fakturowanie.shared.dto.PozycjaDTO;

@Stateless
public class FakturaDAO {

	@PersistenceContext(unitName = "cwiczenie2")
	private EntityManager entityManager;

	public void stworzFakture(Faktura faktura) {
		entityManager.merge(faktura);
	}

	public List<FakturaDTO> wczytajWszystkieFaktury() {
		List<FakturaDTO> listaFakturDTO = new ArrayList<>();
		Query query = entityManager.createQuery("FROM Faktura");
		List<Faktura> listaFaktur = query.getResultList();

		for (Faktura faktura : listaFaktur) {
			List<PozycjaDTO> listaPozycjiDTO = new ArrayList<>();

			for (Pozycja pozycja : faktura.getPozycja()) {

				if (pozycja.getClass() == Produkt.class) {
					listaPozycjiDTO.add(((Produkt) pozycja).stworzPozycjaDTO());
				} else if (pozycja.getClass() == Usluga.class) {
					listaPozycjiDTO.add(((Usluga) pozycja).stworzPozycjaDTO());
				}
			}
			listaFakturDTO.add(faktura.stworzFaktureDTO(listaPozycjiDTO));
		}
		return listaFakturDTO;
	}

	public FakturaDTO wczytajOstatnioDodana() {

		Query query = entityManager.createQuery(
				"Select OBJECT(faktura) FROM Faktura faktura where faktura.nrFaktury=(select max(faktura2.nrFaktury) from Faktura faktura2)");
		Faktura faktura = (Faktura) query.getSingleResult();

		List<PozycjaDTO> listaPozycjiDTO = new ArrayList<>();
		for (Pozycja pozycja : faktura.getPozycja()) {

			if (pozycja.getClass() == Produkt.class) {
				listaPozycjiDTO.add(((Produkt) pozycja).stworzPozycjaDTO());
			} else if (pozycja.getClass() == Usluga.class) {
				listaPozycjiDTO.add(((Usluga) pozycja).stworzPozycjaDTO());
			}
		}
		FakturaDTO fakturaDTO = faktura.stworzFaktureDTO(listaPozycjiDTO);
		return fakturaDTO;
	}
}