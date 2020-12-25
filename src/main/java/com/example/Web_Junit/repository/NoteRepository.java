package com.example.Web_Junit.repository;

import com.example.Web_Junit.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
