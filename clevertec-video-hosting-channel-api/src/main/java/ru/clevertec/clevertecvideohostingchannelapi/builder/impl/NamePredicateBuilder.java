package ru.clevertec.clevertecvideohostingchannelapi.builder.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;
import ru.clevertec.clevertecvideohostingchannelapi.builder.IFilterChannelPredicateBuilder;
import ru.clevertec.clevertecvideohostingchannelapi.dto.FilterChannelDto;

@Component
public class NamePredicateBuilder implements IFilterChannelPredicateBuilder {

    @Override
    public Predicate build(Root<?> root, CriteriaBuilder criteriaBuilder, FilterChannelDto filterChannelDto) {
        if (filterChannelDto == null) {
            return null;
        }
        return criteriaBuilder.equal(root.get("name"), filterChannelDto.getName());
    }
}
