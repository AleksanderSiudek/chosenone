package com.example.chosenone;

import java.util.Objects;

public class Member {
    private final String id; // np. numer lokalu albo UUID
    private final String imieNazwisko;

    public Member(String id, String imieNazwisko) {
        // TODO: walidacja jak w MediaItem - znasz już wzorzec:
        // ify na górze (null/isBlank), przypisania na dole
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be empty or null");
        }
        if (imieNazwisko == null || imieNazwisko.isBlank()) {
            throw new IllegalArgumentException("nameAndUsername cannot be empty or null");
        }
        this.id = id;
        this.imieNazwisko = imieNazwisko;
    }

 

    public String getId() {
        return id;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        var member = (Member) o;
        return Objects.equals(id, member.id);
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    // equals/hashCode po id (klucz biznesowy) - dokładnie ta sama zasada
    // co isbn w MediaItem
}