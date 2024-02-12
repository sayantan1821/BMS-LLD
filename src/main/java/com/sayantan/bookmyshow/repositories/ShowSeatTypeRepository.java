package com.sayantan.bookmyshow.repositories;

import com.sayantan.bookmyshow.models.Show;
import com.sayantan.bookmyshow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository {
    List<ShowSeatType> findAllByShow(Show show);
}
