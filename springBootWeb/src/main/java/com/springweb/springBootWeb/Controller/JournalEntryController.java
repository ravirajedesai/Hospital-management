package com.springweb.springBootWeb.Controller;

import com.springweb.springBootWeb.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntryMap=new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntryMap.values());
    }

    @PostMapping
    public boolean createEnrty(@RequestBody JournalEntry myentry){
        journalEntryMap.put(myentry.getId(), myentry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntryMap.get(myId);
    }
    @DeleteMapping("/id/{myId}")
    public JournalEntry deleteJournalEntry(@PathVariable Long myId){
        return journalEntryMap.remove(myId);
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable Long id,@RequestBody JournalEntry myentry){
        return journalEntryMap.put(id,myentry);
    }

}
