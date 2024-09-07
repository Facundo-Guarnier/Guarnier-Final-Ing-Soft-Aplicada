package guarnier.um.service.mapper;

import guarnier.um.domain.Book;
import guarnier.um.domain.BorrowedBook;
import guarnier.um.domain.Client;
import guarnier.um.service.dto.BookDTO;
import guarnier.um.service.dto.BorrowedBookDTO;
import guarnier.um.service.dto.ClientDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BorrowedBook} and its DTO {@link BorrowedBookDTO}.
 */
@Mapper(componentModel = "spring")
public interface BorrowedBookMapper extends EntityMapper<BorrowedBookDTO, BorrowedBook> {
    @Mapping(target = "book", source = "book", qualifiedByName = "bookName")
    @Mapping(target = "client", source = "client", qualifiedByName = "clientEmail")
    BorrowedBookDTO toDto(BorrowedBook s);

    @Named("bookName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    BookDTO toDtoBookName(Book book);

    @Named("clientEmail")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    ClientDTO toDtoClientEmail(Client client);
}
