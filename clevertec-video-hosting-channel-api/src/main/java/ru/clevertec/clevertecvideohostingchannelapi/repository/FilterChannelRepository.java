package ru.clevertec.clevertecvideohostingchannelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.clevertec.clevertecvideohostingchannelapi.model.Channel;

@Repository
public interface FilterChannelRepository extends JpaRepository<Channel, Long>
        , JpaSpecificationExecutor<Channel> {
}
