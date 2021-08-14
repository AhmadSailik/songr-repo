package com.list.songr;


import org.springframework.data.repository.CrudRepository;

public interface SongrRepository extends CrudRepository<Songr,Integer>{

    Iterable<Songr>findAllByalbumSongerId(Integer albumSongerId);
}
