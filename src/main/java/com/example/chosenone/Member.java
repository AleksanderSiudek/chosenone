package com.example.chosenone;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((imieNazwisko == null) ? 0 : imieNazwisko.hashCode());
        return result;
    }

    public String getId() {
        return id;
    }

    public String getImieNazwisko() {
        return imieNazwisko;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (imieNazwisko == null) {
            if (other.imieNazwisko != null)
                return false;
        } else if (!imieNazwisko.equals(other.imieNazwisko))
            return false;
        return true;
    }

    // equals/hashCode po id (klucz biznesowy) - dokładnie ta sama zasada
    // co isbn w MediaItem
}