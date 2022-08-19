package com.doni.blog.repository;

import com.doni.blog.model.ContentVo;
import com.doni.blog.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class MemoryContentRepository implements ContentRepository{
    @Override
    public List<ContentVo> findAll() {
        return null;
    }

    @Override
    public List<ContentVo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ContentVo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ContentVo> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ContentVo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ContentVo> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends ContentVo> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ContentVo> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ContentVo> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<ContentVo> findAllByUser(User user) {
        return null;
    }



    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ContentVo> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ContentVo> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ContentVo> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ContentVo getOne(Long aLong) {
        return null;
    }

    @Override
    public ContentVo getById(Long aLong) {
        return null;
    }

    @Override
    public ContentVo getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ContentVo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ContentVo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ContentVo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ContentVo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ContentVo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ContentVo> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ContentVo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
