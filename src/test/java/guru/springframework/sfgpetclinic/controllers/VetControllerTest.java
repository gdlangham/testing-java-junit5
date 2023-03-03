package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.VetMapModel;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VetControllerTest implements ControllerTests {

    VetController controller;

    VetService service;

    @BeforeEach
    void setup() {
        service = new VetMapService(new SpecialityMapService());
        Speciality s1 = new Speciality();
        s1.setId(1L);
        s1.setDescription("Horseys");
        Set<Speciality> vetset = new HashSet<>();
        vetset.add(s1);
        Vet v1 = new Vet(null, "Johnny", "Carson", vetset);
        service.save(v1);
        controller = new VetController(service);
    }
    @Test
    void listVets() {

        VetMapModel vmodel = new VetMapModel();
        Vet v = service.findById(1L);
        vmodel.addAttribute("vets", v);
        assertEquals("vets/index", controller.listVets(vmodel));
        Set attr = (Set)vmodel.getModelMap().get("vets");
        Vet vet = (Vet)attr.stream().iterator().next();
        assertEquals("Johnny", vet.getFirstName());
        assertEquals(1, attr.size());



    }
}