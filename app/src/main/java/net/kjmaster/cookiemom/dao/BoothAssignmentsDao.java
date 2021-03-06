/*
 * Copyright (c) 2014.  Author:Steven Dees(kjstevokjmaster@gmail.com)
 *
 *     This program is free software; you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation; either version 2 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License along
 *     with this program; if not, write to the Free Software Foundation, Inc.,
 *     51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package net.kjmaster.cookiemom.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table BOOTH_ASSIGNMENTS.
 */
@SuppressWarnings("ALL")
public class BoothAssignmentsDao extends AbstractDao<BoothAssignments, Long> {

    public static final String TABLENAME = "BOOTH_ASSIGNMENTS";

    /**
     * Properties of entity BoothAssignments.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BoothAssignScoutId = new Property(1, Long.class, "boothAssignScoutId", false, "BOOTH_ASSIGN_SCOUT_ID");
        public final static Property BoothAssignBoothId = new Property(2, Long.class, "boothAssignBoothId", false, "BOOTH_ASSIGN_BOOTH_ID");
    }

    ;

    private DaoSession daoSession;

    private Query<BoothAssignments> scout_BoothsAssignedQuery;
    private Query<BoothAssignments> booth_ScoutsAssignedQuery;

    public BoothAssignmentsDao(DaoConfig config) {
        super(config);
    }

    public BoothAssignmentsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'BOOTH_ASSIGNMENTS' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'BOOTH_ASSIGN_SCOUT_ID' INTEGER," + // 1: boothAssignScoutId
                "'BOOTH_ASSIGN_BOOTH_ID' INTEGER);"); // 2: boothAssignBoothId
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'BOOTH_ASSIGNMENTS'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, BoothAssignments entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        Long boothAssignScoutId = entity.getBoothAssignScoutId();
        if (boothAssignScoutId != null) {
            stmt.bindLong(2, boothAssignScoutId);
        }

        Long boothAssignBoothId = entity.getBoothAssignBoothId();
        if (boothAssignBoothId != null) {
            stmt.bindLong(3, boothAssignBoothId);
        }
    }

    @Override
    protected void attachEntity(BoothAssignments entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public BoothAssignments readEntity(Cursor cursor, int offset) {
        BoothAssignments entity = new BoothAssignments( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // boothAssignScoutId
                cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // boothAssignBoothId
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, BoothAssignments entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBoothAssignScoutId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setBoothAssignBoothId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(BoothAssignments entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(BoothAssignments entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    /**
     * Internal query to resolve the "boothsAssigned" to-many relationship of Scout.
     */
    public List<BoothAssignments> _queryScout_BoothsAssigned(Long boothAssignScoutId) {
        synchronized (this) {
            if (scout_BoothsAssignedQuery == null) {
                QueryBuilder<BoothAssignments> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.BoothAssignScoutId.eq(null));
                scout_BoothsAssignedQuery = queryBuilder.build();
            }
        }
        Query<BoothAssignments> query = scout_BoothsAssignedQuery.forCurrentThread();
        query.setParameter(0, boothAssignScoutId);
        return query.list();
    }

    /**
     * Internal query to resolve the "scoutsAssigned" to-many relationship of Booth.
     */
    public List<BoothAssignments> _queryBooth_ScoutsAssigned(Long boothAssignBoothId) {
        synchronized (this) {
            if (booth_ScoutsAssignedQuery == null) {
                QueryBuilder<BoothAssignments> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.BoothAssignBoothId.eq(null));
                booth_ScoutsAssignedQuery = queryBuilder.build();
            }
        }
        Query<BoothAssignments> query = booth_ScoutsAssignedQuery.forCurrentThread();
        query.setParameter(0, boothAssignBoothId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getScoutDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getBoothDao().getAllColumns());
            builder.append(" FROM BOOTH_ASSIGNMENTS T");
            builder.append(" LEFT JOIN SCOUT T0 ON T.'BOOTH_ASSIGN_SCOUT_ID'=T0.'_id'");
            builder.append(" LEFT JOIN BOOTH T1 ON T.'BOOTH_ASSIGN_BOOTH_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected BoothAssignments loadCurrentDeep(Cursor cursor, boolean lock) {
        BoothAssignments entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Scout scout = loadCurrentOther(daoSession.getScoutDao(), cursor, offset);
        entity.setScout(scout);
        offset += daoSession.getScoutDao().getAllColumns().length;

        Booth booth = loadCurrentOther(daoSession.getBoothDao(), cursor, offset);
        entity.setBooth(booth);

        return entity;
    }

    public BoothAssignments loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();

        String[] keyArray = new String[]{key.toString()};
        Cursor cursor = db.rawQuery(sql, keyArray);

        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }

    /**
     * Reads all available rows from the given cursor and returns a list of new ImageTO objects.
     */
    public List<BoothAssignments> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<BoothAssignments> list = new ArrayList<BoothAssignments>(count);

        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }

    protected List<BoothAssignments> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }


    /**
     * A raw-style query where you can pass any WHERE clause and arguments.
     */
    public List<BoothAssignments> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }

}
