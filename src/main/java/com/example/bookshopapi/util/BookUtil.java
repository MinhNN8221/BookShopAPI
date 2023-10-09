package com.example.bookshopapi.util;

import com.example.bookshopapi.dto.objectdto.bookdto.*;
import com.example.bookshopapi.entity.Book;
import com.example.bookshopapi.entity.CartItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookUtil {
    public List<BookHotNewDto> addBookNewHot(List<Book> books) {
        List<BookHotNewDto> bookHotNews = new ArrayList<>();
        for (Book book : books) {
            BookHotNewDto bookHotNew = new BookHotNewDto();
            bookHotNew.setProduct_id(book.getId());
            bookHotNew.setName(book.getName());
            bookHotNew.setDescription(book.getDescription());
            bookHotNew.setPrice(book.getPrice() + "");
            bookHotNew.setDiscounted_price(book.getDiscounted_price() + "");
            bookHotNew.setQuantity(book.getQuantity());
            bookHotNew.setQuantitySold(book.getQuantitySold());
            bookHotNew.setThumbnail(book.getThumbnail());
            bookHotNews.add(bookHotNew);
        }
        return bookHotNews;
    }

    public List<BookDto> addBook(List<Book> books) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = new BookDto(book.getId(), book.getName(), book.getDescription(), book.getPrice() + "", book.getDiscounted_price() + "", book.getQuantity(), book.getQuantitySold(),
                    book.getImage(), book.getImage_2(), book.getThumbnail(), book.getAuthor().getId(), book.getSupplier().getId(), book.getCategory().getId());
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    public List<BookBannerDto> addBookBanner(List<Book> books) {
        List<BookBannerDto> bookBannerDtos = new ArrayList<>();
        for (Book book : books) {
            BookBannerDto bookBanner = new BookBannerDto();
            bookBanner.setProduct_id(book.getId());
            bookBanner.setName(book.getName());
            bookBanner.setDescription(book.getDescription());
            bookBanner.setPrice(book.getPrice() + "");
            bookBanner.setDiscounted_price(book.getDiscounted_price() + "");
            bookBanner.setQuantity(book.getQuantity());
            bookBanner.setQuantitySold(book.getQuantitySold());
            bookBanner.setThumbnail(book.getThumbnail());
            bookBanner.setBanner_url(book.getBanner());
            bookBannerDtos.add(bookBanner);
        }
        return bookBannerDtos;
    }

    public List<BookInCartDto> addToBookInCartDto(List<CartItem> cartItems, List<Book> booksInWishlist) {
        List<BookInCartDto> bookList = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            BookInCartDto bookInCartDto = new BookInCartDto();
            bookInCartDto.setItem_id(cartItem.getId());
            bookInCartDto.setName(cartItem.getBook().getName());
            bookInCartDto.setPrice(cartItem.getBook().getPrice() + "");
            bookInCartDto.setDiscounted_price(cartItem.getBook().getDiscounted_price() + "");
            bookInCartDto.setQuantity(cartItem.getQuantity());
            bookInCartDto.setProduct_id(cartItem.getBook().getId());
            bookInCartDto.setAdded_on(cartItem.getAddOn());
            bookInCartDto.setSub_total(cartItem.getBook().getDiscounted_price().multiply(new BigDecimal(cartItem.getQuantity())) + "");
            bookInCartDto.setImage(cartItem.getBook().getImage());
            int wishList = 0;
            for (Book book : booksInWishlist) {
                if (cartItem.getBook().getId() == book.getId()) {
                    wishList = 1;
                }
            }
            bookInCartDto.setWishlist(wishList);
            bookList.add(bookInCartDto);
        }
        return bookList;
    }

    public BookDetailDto addBookDetailDto(Book book, List<Book> booksInWishlist) {
        BookDetailDto bookDetailDto = new BookDetailDto();
        bookDetailDto.setProduct_id(book.getId());
        bookDetailDto.setName(book.getName());
        bookDetailDto.setDescription(book.getDescription());
        bookDetailDto.setPrice(book.getPrice() + "");
        bookDetailDto.setDiscounted_price(book.getDiscounted_price()+"");
        bookDetailDto.setQuantity(book.getQuantity());
        bookDetailDto.setQuantitySold(book.getQuantitySold());
        bookDetailDto.setThumbnail(book.getThumbnail());
        int wishlist = 0;
        for (Book bookWishlist : booksInWishlist) {
            if (book.getId() == bookWishlist.getId()) {
                wishlist = 1;
            }
        }
        bookDetailDto.setWishlist(wishlist);
        return bookDetailDto;
    }
}
