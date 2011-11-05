package facilitybookingsystem.impl.domain.equipment;

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO: Documentation
 *
 * @author edward.yakop@mincom.com
 * @since 0.3
 */
@Named
public class EquipmentRepository
{
    @PersistenceContext
    EntityManager entityManager;

    //Get all equipment
    @Transactional
    public List<Equipment> getAllEquipment()
    {
        return entityManager.createNamedQuery( "equipment.findAll", Equipment.class )
            .getResultList();
    }

    //Find a piece of equipment given the id
    @Transactional
    public Equipment findEquipmentId( String Id )
    {
        return entityManager.createNamedQuery( "equipment.findById", Equipment.class )
            .setParameter( "id", Id )
            .getSingleResult();
    }

    // TODO: find available equipment
}
