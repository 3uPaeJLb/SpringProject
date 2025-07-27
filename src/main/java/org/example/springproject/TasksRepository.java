package org.example.springproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Long> {

    void deleteByName(String name);
}
