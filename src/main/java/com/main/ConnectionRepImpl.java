package com.main;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Created by khanguyen on 21/02/2017.
 */
public class ConnectionRepImpl implements ConnectionRepository {
    @Override
    public MultiValueMap<String, Connection<?>> findAllConnections() {
        return null;
    }

    @Override
    public List<Connection<?>> findConnections(String s) {
        return null;
    }

    @Override
    public <A> List<Connection<A>> findConnections(Class<A> aClass) {
        return null;
    }

    @Override
    public MultiValueMap<String, Connection<?>> findConnectionsToUsers(MultiValueMap<String, String> multiValueMap) {
        return null;
    }

    @Override
    public Connection<?> getConnection(ConnectionKey connectionKey) {
        return null;
    }

    @Override
    public <A> Connection<A> getConnection(Class<A> aClass, String s) {
        return null;
    }

    @Override
    public <A> Connection<A> getPrimaryConnection(Class<A> aClass) {
        return null;
    }

    @Override
    public <A> Connection<A> findPrimaryConnection(Class<A> aClass) {
        return null;
    }

    @Override
    public void addConnection(Connection<?> connection) {
//create connection data

    }

    @Override
    public void updateConnection(Connection<?> connection) {

    }

    @Override
    public void removeConnections(String s) {

    }

    @Override
    public void removeConnection(ConnectionKey connectionKey) {

    }
}
