package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private Long lastIdOfFaculty = 0L;

    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(++lastIdOfFaculty);
        faculties.put(lastIdOfFaculty, faculty);
        return faculty;
    }

    public Faculty findFaculty (Long id){
        if (faculties.containsKey(id)) {
            return faculties.get(id);
        }
        return null;
    }

    public Faculty editFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty (Long id){
        if (faculties.containsKey(id)) {
            return faculties.remove(id);
        }
        return null;
    }

    public List<Faculty> getFacultiesByColor(String color) {
        return faculties.values().stream().
                filter(e -> e.getColor().equals(color)).toList();
    }
}
