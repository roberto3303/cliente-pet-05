package br.com.petz.cliente_pet.pet.application.api;

import br.com.petz.cliente_pet.cliente.application.api.ClienteListResponse;
import br.com.petz.cliente_pet.pet.domain.Pet;
import br.com.petz.cliente_pet.pet.domain.TipoPet;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PetClienteListResponse {
    private UUID idPet;
    private String nomePet;
    private TipoPet tipoPet;
    private String raca;
    private String pelagemCor;
    private LocalDate dataNascimento;

    public static List<PetClienteListResponse> converte(List<Pet> petsDoCliente) {
        return petsDoCliente.stream()
                .map(PetClienteListResponse:: new)
                .collect(Collectors.toList());
    }

    public PetClienteListResponse(Pet pet) {
        this.idPet = pet.getIdPet();
        this.nomePet = pet.getNomePet();
        this.tipoPet = pet.getTipoPet();
        this.raca = pet.getRaca();
        this.pelagemCor = pet.getPelagemCor();
        this.dataNascimento = pet.getDataNascimento();
    }
}
