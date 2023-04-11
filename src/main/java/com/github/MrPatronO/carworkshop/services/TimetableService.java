package com.github.MrPatronO.carworkshop.services;

import com.github.MrPatronO.carworkshop.dtos.NewTimetableDto;
import com.github.MrPatronO.carworkshop.dtos.TimetableDto;
import com.github.MrPatronO.carworkshop.models.Timetable;
import com.github.MrPatronO.carworkshop.repositories.TimetableRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TimetableService {

    final TimetableRepository timetableRepository;

    @PersistenceContext
    EntityManager entityManager;

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    public TimetableDto save(NewTimetableDto newTimetableDto) {

        if(newTimetableDto.getEndOfRepair().isBefore(newTimetableDto.getStartOfRepair())){
            throw new IllegalArgumentException("End repair can't be before start repair");
        }

        long daysBetweenStartAndEndRepair = ChronoUnit.DAYS.between(newTimetableDto.getStartOfRepair(), newTimetableDto.getEndOfRepair());

        if (daysBetweenStartAndEndRepair>30){
            throw new IllegalArgumentException("Between start and end repair date can't be more than 30 days");
        }

        List foundedTimetables = timetableRepository.findTimetableInPeriod(newTimetableDto.getStartOfRepair(), newTimetableDto.getEndOfRepair());
        if (foundedTimetables.size() > 0){
            throw new IllegalArgumentException("This term is busy!");
        }


        Timetable timetable = new Timetable();
        timetable.setEndOfRepair(newTimetableDto.getEndOfRepair());
        timetable.setStartOfRepair(newTimetableDto.getStartOfRepair());
        timetable.setWorkplace(newTimetableDto.getWorkplaceId().intValue());


        Timetable newTimetable = timetableRepository.save(timetable);

        return mapToTimetableDto(newTimetable);
    }

    public Optional<Timetable> findById(Long timetableId) {
        return timetableRepository.findById(timetableId);
    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    public TimetableDto update(TimetableDto timetableDto, Long timetableId) {
        Timetable updatedOrCreatedTimetable = timetableRepository.findById(timetableId)
                .map(timetable -> {
                    mapToTimetable(timetable, timetableDto);

                    return timetableRepository.save(timetable);
                })
                .orElseGet(() -> {
                    Timetable timetable = new Timetable();
                    mapToTimetable(timetable, timetableDto);

                    return timetableRepository.save(timetable);
                });

        return mapToTimetableDto(updatedOrCreatedTimetable);
    }

//SELECT timetable.start_of_repair, timetable.end_of_repair from car_workshop.timetable where start_of_repair > '2024-01-12 00:00:00' AND end_of_repair > '2024-01-13 00:00:00'

    public void deleteById(Long id) {
        timetableRepository.deleteById(id);
    }


    public List<TimetableDto> findReservedTimetable(Long workplaceId, Integer year, Integer month) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Timetable> criteriaQuery = criteriaBuilder.createQuery(Timetable.class);

        Root<Timetable> timetableRoot = criteriaQuery.from(Timetable.class);

        Predicate workplacePredicate = criteriaBuilder.equal(timetableRoot.get("workplace"), workplaceId);
        Predicate startYearPredicate = year != null ? criteriaBuilder.equal(criteriaBuilder.function("YEAR", Integer.class, timetableRoot.get("startOfRepair")), year) : null;
        Predicate startMonthPredicate = month != null && month > 0 && month < 13 ? criteriaBuilder.equal(criteriaBuilder.function("MONTH", Integer.class, timetableRoot.get("startOfRepair")), month) : null;
        Predicate wherePredicate = startMonthPredicate != null ? criteriaBuilder.and(workplacePredicate, startYearPredicate, startMonthPredicate) : startYearPredicate != null ? criteriaBuilder.and(workplacePredicate, startYearPredicate) : criteriaBuilder.and(workplacePredicate);
        criteriaQuery.where(wherePredicate);

        TypedQuery<Timetable> timetableTypedQuery = entityManager.createQuery(criteriaQuery);
        return timetableTypedQuery.getResultList()
                .stream()
                .map(timetable -> {
                            TimetableDto timetableDto = new TimetableDto();
                            timetableDto.setTimetableId(timetable.getTimetableId());
                            timetableDto.setEndOfRepair(timetable.getEndOfRepair());
                            timetableDto.setStartOfRepair(timetable.getStartOfRepair());
                            timetableDto.setWorkplace(timetable.getWorkplace());

                            return timetableDto;
                        }
                ).collect(Collectors.toList());
    }

    private TimetableDto mapToTimetableDto(Timetable timetable){
        TimetableDto timetableDto = new TimetableDto();
        timetableDto.setTimetableId(timetable.getTimetableId());
        timetableDto.setEndOfRepair(timetable.getEndOfRepair());
        timetableDto.setStartOfRepair(timetable.getStartOfRepair());
        timetableDto.setWorkplace(timetable.getWorkplace());

        return timetableDto;
    }

    private void mapToTimetable(Timetable timetable, TimetableDto timetableDto){
        timetable.setEndOfRepair(timetableDto.getEndOfRepair());
        timetable.setStartOfRepair(timetableDto.getStartOfRepair());
        timetable.setWorkplace(timetableDto.getWorkplace());
    }

}
