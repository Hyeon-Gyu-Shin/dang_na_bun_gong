package com.example.dang_na_bun_gong.Repository;

import com.example.dang_na_bun_gong.Entity.MemberEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

	boolean existsById(String memberid);
	boolean existsByMembertel(String membertel);
	boolean existsByMembermail(String membermail);

	Optional<MemberEntity> findByMemberidAndMemberpw(String memberid, String memberpw);
	
	@Query(value = "select count(member_id) from member where member_id = :memberid and member_pw = :memberpw", nativeQuery=true)
    Integer loginCheck(@Param("memberid") String memberid, @Param("memberpw") String memberpw);
	
    @Query(value = "select name, age from member where name = :name", nativeQuery=true)
    List<MemberEntity> searchParamRepo(@Param("name") String name);


	MemberEntity findByMemberid(String memberid);

}