package tn.esprit.rh.achat.services;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeleteFournisseur() {
        // Mock data
        Long fournisseurId = 1L;

        // Test
        fournisseurService.deleteFournisseur(fournisseurId);

        // Verify that deleteById method is called with correct fournisseurId
        verify(fournisseurRepository).deleteById(fournisseurId);
    }
}