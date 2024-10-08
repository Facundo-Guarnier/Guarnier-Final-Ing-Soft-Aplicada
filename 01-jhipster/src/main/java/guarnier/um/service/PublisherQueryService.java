package guarnier.um.service;

import guarnier.um.domain.*; // for static metamodels
import guarnier.um.domain.Publisher;
import guarnier.um.repository.PublisherRepository;
import guarnier.um.service.criteria.PublisherCriteria;
import guarnier.um.service.dto.PublisherDTO;
import guarnier.um.service.mapper.PublisherMapper;
import java.util.List;
import javax.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Publisher} entities in the database.
 * The main input is a {@link PublisherCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PublisherDTO} or a {@link Page} of {@link PublisherDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PublisherQueryService extends QueryService<Publisher> {

    private final Logger log = LoggerFactory.getLogger(PublisherQueryService.class);

    private final PublisherRepository publisherRepository;

    private final PublisherMapper publisherMapper;

    public PublisherQueryService(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    /**
     * Return a {@link List} of {@link PublisherDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PublisherDTO> findByCriteria(PublisherCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Publisher> specification = createSpecification(criteria);
        return publisherMapper.toDto(publisherRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PublisherDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PublisherDTO> findByCriteria(PublisherCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Publisher> specification = createSpecification(criteria);
        return publisherRepository.findAll(specification, page).map(publisherMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PublisherCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Publisher> specification = createSpecification(criteria);
        return publisherRepository.count(specification);
    }

    /**
     * Function to convert {@link PublisherCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Publisher> createSpecification(PublisherCriteria criteria) {
        Specification<Publisher> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            if (criteria.getDistinct() != null) {
                specification = specification.and(distinct(criteria.getDistinct()));
            }
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Publisher_.id));
            }
            if (criteria.getName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getName(), Publisher_.name));
            }
        }
        return specification;
    }
}
