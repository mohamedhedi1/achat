package tn.esprit.rh.achat.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    @Mock
    private ProduitRepository produitRepository;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        // Mock data
        List<Fournisseur> fournisseurs = new ArrayList<>();
        fournisseurs.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // Test
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Verify
        assertEquals(fournisseurs.size(), result.size());
        verify(fournisseurRepository, times(1)).findAll();
    }

    @Test
    public void testAddFournisseur() {
        // Mock data
        Fournisseur fournisseur = new Fournisseur();
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);

        // Test
        when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);
        Fournisseur result = fournisseurService.addFournisseur(fournisseur);

        // Verify
        assertEquals(detailFournisseur.getDateDebutCollaboration(), new Date());
        verify(fournisseurRepository, times(1)).save(fournisseur);
    }
}