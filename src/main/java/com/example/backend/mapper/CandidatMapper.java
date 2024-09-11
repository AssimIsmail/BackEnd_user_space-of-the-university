package com.example.backend.mapper;

import com.example.backend.dto.CandidatDTO;
import com.example.backend.model.Candidat;
import com.example.backend.service.PaysService;
import com.example.backend.service.ProfessionsService;
import com.example.backend.service.SerieBacService;
import com.example.backend.service.VilleService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class CandidatMapper {

    @Autowired
    private PaysService paysService;

    @Autowired
    private ProfessionsService professionsService;

    @Autowired
    private SerieBacService serieBacService;

    @Autowired
    private VilleService villeService;

    public CandidatDTO toDTO(Candidat candidat) {
        if (candidat == null) {
            return null;
        }
        CandidatDTO dto = new CandidatDTO();
        dto.setId(candidat.getId());
        dto.setNomFr(candidat.getNomFr());
        dto.setNomAr(candidat.getNomAr());
        dto.setPrenomFr(candidat.getPrenomFr());
        dto.setPrenomAr(candidat.getPrenomAr());
        dto.setCne(candidat.getCne());
        dto.setCni(candidat.getCni());
        dto.setSexe(candidat.getSexe());
        dto.setDn(candidat.getDn());
        dto.setLnFr(candidat.getLnFr());
        dto.setLnAr(candidat.getLnAr());
        dto.setTel(candidat.getTel());
        dto.setEmail(candidat.getEmail());
        dto.setFichierJointOrig(candidat.getFichierJointOrig());
        dto.setFichierJointOld(candidat.getFichierJointOld());
        dto.setFichierJoint(candidat.getFichierJoint());
        dto.setLogin(candidat.getLogin());
        dto.setPassword(candidat.getPassword());
        dto.setStatut(candidat.getStatut());
        dto.setStatutOld(candidat.getStatutOld());
        dto.setStatutOld2(candidat.getStatutOld2());
        dto.setStatutNew(candidat.getStatutNew());
        dto.setMotif(candidat.getMotif());
        dto.setCdDip(candidat.getCdDip());
        dto.setVilleId(candidat.getVille() != null ? candidat.getVille().getId() : null);
        dto.setPaysId(candidat.getPays() != null ? candidat.getPays().getId() : null);
        dto.setProfessionId(candidat.getProfession() != null ? candidat.getProfession().getId() : null);
        dto.setSerieBacId(candidat.getSerieBac() != null ? candidat.getSerieBac().getId() : null);
        dto.setAdresse(candidat.getAdresse());
        dto.setRememberToken(candidat.getRememberToken());
        dto.setCreatedAt(candidat.getCreatedAt());
        dto.setUpdatedAt(candidat.getUpdatedAt());
        dto.setDeletedAt(candidat.getDeletedAt());
        dto.setCandidatToken(candidat.getCandidatToken());
        dto.setAnneeBac(candidat.getAnneeBac());

//        // Nouveaux attributs ajoutés
//        dto.setEtat(candidat.getEtat());
//        dto.setJustificationUn(candidat.getJustificationUn());
//        dto.setJustificationDeux(candidat.getJustificationDeux());
//        dto.setJustificationTrois(candidat.getJustificationTrois());
//        dto.setJustificationQuatre(candidat.getJustificationQuatre());
//        dto.setJustificationCinq(candidat.getJustificationCinq());

        return dto;
    }

    public Candidat toEntity(CandidatDTO dto) {
        if (dto == null) {
            return null;
        }
        Candidat candidat = new Candidat();
        candidat.setId(dto.getId());
        candidat.setNomFr(dto.getNomFr());
        candidat.setNomAr(dto.getNomAr());
        candidat.setPrenomFr(dto.getPrenomFr());
        candidat.setPrenomAr(dto.getPrenomAr());
        candidat.setCne(dto.getCne());
        candidat.setCni(dto.getCni());
        candidat.setSexe(dto.getSexe());
        candidat.setDn(dto.getDn());
        candidat.setLnFr(dto.getLnFr());
        candidat.setLnAr(dto.getLnAr());
        candidat.setTel(dto.getTel());
        candidat.setEmail(dto.getEmail());
        candidat.setFichierJointOrig(dto.getFichierJointOrig());
        candidat.setFichierJointOld(dto.getFichierJointOld());
        candidat.setFichierJoint(dto.getFichierJoint());
        candidat.setLogin(dto.getLogin());
        candidat.setPassword(dto.getPassword());
        candidat.setStatut(dto.getStatut());
        candidat.setStatutOld(dto.getStatutOld());
        candidat.setStatutOld2(dto.getStatutOld2());
        candidat.setStatutNew(dto.getStatutNew());
        candidat.setMotif(dto.getMotif());
        candidat.setCdDip(dto.getCdDip());
        candidat.setAdresse(dto.getAdresse());
        candidat.setRememberToken(dto.getRememberToken());
        candidat.setCandidatToken(dto.getCandidatToken());
        candidat.setAnneeBac(dto.getAnneeBac());

        // Fetch and set related entities (handle these in the service layer)
//        // You may need to fetch these entities in the service layer where you use this mapper
//
//        // Nouveaux attributs ajoutés
//        candidat.setEtat(dto.getEtat());
//        candidat.setJustificationUn(dto.getJustificationUn());
//        candidat.setJustificationDeux(dto.getJustificationDeux());
//        candidat.setJustificationTrois(dto.getJustificationTrois());
//        candidat.setJustificationQuatre(dto.getJustificationQuatre());
//        candidat.setJustificationCinq(dto.getJustificationCinq());

        return candidat;
    }
}
