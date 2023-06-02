package com.example.DTO.controller;

import com.example.DTO.dto.PokemonDto;
import com.example.DTO.dto.RoleDto;
import com.example.DTO.entity.Pokemon;
import com.example.DTO.entity.Role;
import com.example.DTO.entity.User;
import com.example.DTO.repository.PokemonRepository;
import com.example.DTO.repository.UserRepository;
import com.example.DTO.service.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PokemonRepository pokemonRepository;


    @Autowired
    RoleMapper roleMapper;

    @GetMapping("/userPokemonsList")
    public ResponseEntity<?> getUserPokemonsList() {
        User user = userRepository.findById(1L).get();
        List<Pokemon> pokemons = user.getPokemons();
        List<PokemonDto> pokemonsDto = new ArrayList<PokemonDto>();
        int i = 0;
        for (Pokemon pokemon : pokemons) {
            PokemonDto pokemonDto = new PokemonDto();
            pokemonDto.setName(pokemon.getName());
            pokemonDto.setAttribut(pokemon.getAttribut());
            pokemonsDto.add(i, pokemonDto);
            i++;
        }
        return new ResponseEntity<>(pokemonsDto, HttpStatus.OK);
    }

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<?> getPokemonByName(@PathVariable String name) {
        Pokemon pokemon = pokemonRepository.findByName(name);
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setAttribut(pokemon.getAttribut());
        return new ResponseEntity<>(pokemonDto, HttpStatus.OK);
    }


    @GetMapping("/rolesSuccessBaic")
    public ResponseEntity<?> getRoles() {
        User user = userRepository.findById(1L).get();
        List<Role> roles = user.getRoles();
        List<RoleDto> rolesDto = new ArrayList<RoleDto>();
        int i = 0;
        for (Role role : roles) {
            RoleDto roleDto = new RoleDto();
            roleDto.setName(role.getName());
            roleDto.setUserName(user.getName());
            roleDto.setId(role.getId());
            rolesDto.add(i, roleDto);
            i++;
        }
        return new ResponseEntity<>(rolesDto, HttpStatus.OK);
    }

    @GetMapping("/rolesSuccessMapper")
    public ResponseEntity<?> getRolesMapper() {
        User user = userRepository.findById(1L).get();
        List<Role> roles = user.getRoles();
        List<RoleDto> rolesDto = new ArrayList<RoleDto>();
        int i = 0;
        for (Role role : roles) {
            RoleDto roleDto = roleMapper.TransformRoleEntityInRoleDto(role);
            rolesDto.add(i, roleDto);
            i++;
        }
        return new ResponseEntity<>(rolesDto, HttpStatus.OK);
    }

    // Error jackson infinite recursion
    @GetMapping("/rolesError")
    public ResponseEntity<?> getRolesError() {
        User user = userRepository.findById(1L).get();
        List<Role> roles = user.getRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
