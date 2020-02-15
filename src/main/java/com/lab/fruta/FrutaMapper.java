package com.lab.fruta;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author lucas
 */
@Mapper
public interface FrutaMapper {

    @Select("SELECT f.id, f.nome AS fruta, f.nome_cientifico, f.id_familia, ff.nome AS familia "
            + "FROM pgd.tb_fruta f INNER JOIN pgd.tb_familia_fruta ff "
            + "ON f.id_familia = ff.id")
    @Results(value = {
        @Result(column = "id", property = "id"),
        @Result(column = "fruta", property = "nome"),
        @Result(column = "nome_cientifico", property = "nomeCientifico"),
        @Result(column = "id_familia", property = "familia.id"),
        @Result(column = "familia", property = "familia.nome")
    })
    public List<Fruta> listaFrutas();

    @Select("SELECT f.id, f.nome AS fruta, f.nome_cientifico, f.id_familia, ff.nome AS familia "
            + "FROM pgd.tb_fruta f INNER JOIN pgd.tb_familia_fruta ff "
            + "ON f.id_familia = ff.id "
            + "WHERE f.id = #{id}")
    @Results(value = {
        @Result(column = "id", property = "id"),
        @Result(column = "fruta", property = "nome"),
        @Result(column = "nome_cientifico", property = "nomeCientifico"),
        @Result(column = "id_familia", property = "familia.id"),
        @Result(column = "familia", property = "familia.nome")
    })
    public Optional<Fruta> getFruta(@Param("id") Long id);
}
