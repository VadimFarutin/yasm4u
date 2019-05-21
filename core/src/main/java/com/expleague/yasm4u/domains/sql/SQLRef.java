package com.expleague.yasm4u.domains.sql;

import com.expleague.yasm4u.Ref;
import com.expleague.yasm4u.Restriction;

import java.net.URI;
import java.net.URISyntaxException;

public class SQLRef implements Ref<SQLRef, SQLDomain> {
    private final String table;
    private final SQLRestriction restriction;

    public SQLRef(SQLRestriction restriction) {
        this("T_" + String.valueOf(restriction.hashCode()), restriction);
    }

    public SQLRef(String table, SQLRestriction restriction) {
        this.table = table;
        this.restriction = restriction;
    }

    @Override
    public URI toURI() {
        return null;
    }

    @Override
    public Class<SQLRef> type() {
        return SQLRef.class;
    }

    @Override
    public Class<SQLDomain> domainType() {
        return SQLDomain.class;
    }

    @Override
    public Restriction restriction() {
        return restriction;
    }

    @Override
    public SQLRef resolve(SQLDomain controller) {
        return this;
    }

    @Override
    public boolean available(SQLDomain controller) {
        return controller.available(this);
    }

    public String getTable() {
        return table;
    }

    public static SQLRef createFromURI(String uriS, SQLQueryParser parser) {
        try {
            URI uri = new URI(uriS);
            if ("sql".equals(uri.getScheme())) {
                if (uri.getPath().contains("//")) {
                    throw new RuntimeException("//");
                }

                String source = uri.getPath() + (uri.getQuery() != null ? "?" + uri.getQuery() : "");
                return create(source.replace("%20", " "), parser);
            } else {
                throw new IllegalArgumentException("Unsupported protocol: " + uri.getScheme() + " in URI: [" + uriS + "]");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static SQLRef create(String source, SQLQueryParser parser) {
        SQLRestriction restriction = parser.parse(source);
        return new SQLRef(restriction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SQLRef)) return false;

        SQLRef other = (SQLRef) o;

        return table.equals(other.table) && restriction.equals(other.restriction);
    }

    @Override
    public int hashCode() {
        int result = table.hashCode();
        result = 31 * result + restriction.hashCode();

        return result;
    }
}
