package com.usrmdk.arquitecturamvvm.db;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.usrmdk.arquitecturamvvm.model.Contributor;
import com.usrmdk.arquitecturamvvm.model.Repo;
import com.usrmdk.arquitecturamvvm.model.RepoSearchResult;

import java.util.List;

public abstract class RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Repo... repos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertContributors(List<Contributor> contributors);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRepos(List<Repo> repos);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long creatreRepoIfNotExists(Repo repo);

    @Query("SELECT * FROM repo WHERE owner_login = :ownerLogin AND name = :name")
    public abstract LiveData<Repo> load(String ownerLogin, String name);

    @Query("SELECT login, avatarUrl, repoName, repoOwner, contributions FROM contributor WHERE repoName = :name AND repoOwner = :owner ORDER BY contributions DESC")
    public abstract LiveData<List<Contributor>> loadContributors(String owner, String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(RepoSearchResult result);

    @Query("SELECT * FROM RepoSearchResult WHERE `query` = :query")
    public abstract LiveData<RepoSearchResult> search(String query);

    @Query("SELECT * FROM Repo WHERE id in (:repoIds)")
    protected abstract LiveData<List<Repo>> loadById(List<Integer> repoIds);

    @Query("SELECT * FROM RepoSearchResult WHERE `query` = :query")
    public abstract  RepoSearchResult  findSearchResult(String query);




}
