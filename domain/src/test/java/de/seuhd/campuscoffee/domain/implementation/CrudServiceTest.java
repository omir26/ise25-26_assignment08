package de.seuhd.campuscoffee.domain.implementation;

import de.seuhd.campuscoffee.domain.model.objects.Review;
import de.seuhd.campuscoffee.domain.ports.data.CrudDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest {

    @Mock
    private CrudDataService<Review, Long> ds;

    CrudServiceImpl<Review, Long> crudService;

    @BeforeEach
    void setUp() {
        crudService = new CrudServiceImpl<>(Review.class){
            @Override
            protected CrudDataService<Review, Long> dataService() {
                return ds;
            }
        };
    }

    @Test
    void TestDelete(){
        // given
        Long id = 1L;

        // when
        crudService.delete(id);

        // then
        verify(ds).delete(id);
        verifyNoMoreInteractions(ds);

    }

    @Test
    void TestClear(){
        // when
        crudService.clear();

        // then
        verify(ds).clear();
        verifyNoMoreInteractions(ds);
    }
}
