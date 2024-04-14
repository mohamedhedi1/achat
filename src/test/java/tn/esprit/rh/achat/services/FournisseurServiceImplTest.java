package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import static org.mockito.Mockito.*;

public class FournisseurServiceImplTest {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteFournisseur() {
        Long fournisseurId = 1L;
        fournisseurService.deleteFournisseur(fournisseurId);
        verify(fournisseurRepository).deleteById(fournisseurId);
    }
}