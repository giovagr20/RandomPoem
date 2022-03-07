package co.com.poem.generator.PoemGeneratorRandom.application.utilities;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public interface GeneralMapper<D, M> {

    Optional<M> dtoToModel(D dto);

    Optional<D> modelToDto(M modelo);

    default Optional<List<M>> listDtoToListModel(List<D> listaDto) {
        if (listaDto == null) {
            return Optional.empty();
        }

        return Optional.of(listaDto
                .stream()
                .map(dto -> dtoToModel(dto).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }

    default Optional<List<D>> listModelToListDto(List<M> listaModelo) {
        if (listaModelo == null) {
            return Optional.empty();
        }

        return Optional.of(listaModelo
                .stream()
                .map(modelo -> modelToDto(modelo).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }
}
