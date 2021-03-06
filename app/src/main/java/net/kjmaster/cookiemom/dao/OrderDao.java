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
 * DAO for table ORDERS.
 */
@SuppressWarnings("ALL")
public class OrderDao extends AbstractDao<Order, Long> {

    public static final String TABLENAME = "ORDERS";

    /**
     * Properties of entity Order.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property OrderDate = new Property(1, java.util.Date.class, "orderDate", false, "ORDER_DATE");
        public final static Property OrderScoutId = new Property(2, long.class, "orderScoutId", false, "ORDER_SCOUT_ID");
        public final static Property OrderCookieType = new Property(3, String.class, "orderCookieType", false, "ORDER_COOKIE_TYPE");
        public final static Property OrderedFromCupboard = new Property(4, Boolean.class, "orderedFromCupboard", false, "ORDERED_FROM_CUPBOARD");
        public final static Property OrderedBoxes = new Property(5, Integer.class, "orderedBoxes", false, "ORDERED_BOXES");
        public final static Property PickedUpFromCupboard = new Property(6, Boolean.class, "pickedUpFromCupboard", false, "PICKED_UP_FROM_CUPBOARD");
    }

    ;

    private DaoSession daoSession;

    private Query<Order> scout_ScoutOrdersQuery;

    public OrderDao(DaoConfig config) {
        super(config);
    }

    public OrderDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "'ORDERS' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'ORDER_DATE' INTEGER," + // 1: orderDate
                "'ORDER_SCOUT_ID' INTEGER NOT NULL ," + // 2: orderScoutId
                "'ORDER_COOKIE_TYPE' TEXT," + // 3: orderCookieType
                "'ORDERED_FROM_CUPBOARD' INTEGER," + // 4: orderedFromCupboard
                "'ORDERED_BOXES' INTEGER," + // 5: orderedBoxes
                "'PICKED_UP_FROM_CUPBOARD' INTEGER);"); // 6: pickedUpFromCupboard
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ORDERS'";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, Order entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        java.util.Date orderDate = entity.getOrderDate();
        if (orderDate != null) {
            stmt.bindLong(2, orderDate.getTime());
        }
        stmt.bindLong(3, entity.getOrderScoutId());

        String orderCookieType = entity.getOrderCookieType();
        if (orderCookieType != null) {
            stmt.bindString(4, orderCookieType);
        }

        Boolean orderedFromCupboard = entity.getOrderedFromCupboard();
        if (orderedFromCupboard != null) {
            stmt.bindLong(5, orderedFromCupboard ? 1l : 0l);
        }

        Integer orderedBoxes = entity.getOrderedBoxes();
        if (orderedBoxes != null) {
            stmt.bindLong(6, orderedBoxes);
        }

        Boolean pickedUpFromCupboard = entity.getPickedUpFromCupboard();
        if (pickedUpFromCupboard != null) {
            stmt.bindLong(7, pickedUpFromCupboard ? 1l : 0l);
        }
    }

    @Override
    protected void attachEntity(Order entity) {
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
    public Order readEntity(Cursor cursor, int offset) {
        Order entity = new Order( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // orderDate
                cursor.getLong(offset + 2), // orderScoutId
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // orderCookieType
                cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // orderedFromCupboard
                cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // orderedBoxes
                cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0 // pickedUpFromCupboard
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, Order entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOrderDate(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setOrderScoutId(cursor.getLong(offset + 2));
        entity.setOrderCookieType(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setOrderedFromCupboard(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setOrderedBoxes(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setPickedUpFromCupboard(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(Order entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(Order entity) {
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
     * Internal query to resolve the "scoutOrders" to-many relationship of Scout.
     */
    public List<Order> _queryScout_ScoutOrders(long orderScoutId) {
        synchronized (this) {
            if (scout_ScoutOrdersQuery == null) {
                QueryBuilder<Order> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.OrderScoutId.eq(null));
                queryBuilder.orderRaw("ORDER_DATE ASC");
                scout_ScoutOrdersQuery = queryBuilder.build();
            }
        }
        Query<Order> query = scout_ScoutOrdersQuery.forCurrentThread();
        query.setParameter(0, orderScoutId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getScoutDao().getAllColumns());
            builder.append(" FROM ORDERS T");
            builder.append(" LEFT JOIN SCOUT T0 ON T.'ORDER_SCOUT_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected Order loadCurrentDeep(Cursor cursor, boolean lock) {
        Order entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Scout scout = loadCurrentOther(daoSession.getScoutDao(), cursor, offset);
        if (scout != null) {
            entity.setScout(scout);
        }

        return entity;
    }

    public Order loadDeep(Long key) {
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
    public List<Order> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Order> list = new ArrayList<Order>(count);

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

    protected List<Order> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }


    /**
     * A raw-style query where you can pass any WHERE clause and arguments.
     */
    public List<Order> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }

}
