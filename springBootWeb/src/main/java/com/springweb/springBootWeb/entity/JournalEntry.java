package com.springweb.springBootWeb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntry {

    private long id;
    private String title;
    private String content;

}
