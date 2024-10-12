package ru.clevertec.clevertecvideohostingchannelapi.builder;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import ru.clevertec.clevertecvideohostingchannelapi.dto.FilterChannelDto;

public interface IFilterChannelPredicateBuilder {

    Predicate build(Root<?> root, CriteriaBuilder criteriaBuilder, FilterChannelDto filterChannelDto);
}
