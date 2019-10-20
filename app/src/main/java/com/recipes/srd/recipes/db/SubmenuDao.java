package com.recipes.srd.recipes.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SUBMENU".
*/
public class SubmenuDao extends AbstractDao<Submenu, Void> {

    public static final String TABLENAME = "SUBMENU";

    /**
     * Properties of entity Submenu.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", false, "ID");
        public final static Property Mid = new Property(1, int.class, "mid", false, "MID");
        public final static Property Name_Gujrati = new Property(2, String.class, "name_Gujrati", false, "NAME__GUJRATI");
        public final static Property Name_Hindi = new Property(3, String.class, "name_Hindi", false, "NAME__HINDI");
        public final static Property Name_English = new Property(4, String.class, "name_English", false, "NAME__ENGLISH");
        public final static Property Discription_Gujrati = new Property(5, String.class, "discription_Gujrati", false, "DISCRIPTION__GUJRATI");
        public final static Property Discription_Hindi = new Property(6, String.class, "discription_Hindi", false, "DISCRIPTION__HINDI");
        public final static Property Discription_English = new Property(7, String.class, "discription_English", false, "DISCRIPTION__ENGLISH");
        public final static Property Image = new Property(8, String.class, "image", false, "IMAGE");
    }


    public SubmenuDao(DaoConfig config) {
        super(config);
    }
    
    public SubmenuDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SUBMENU\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"MID\" INTEGER NOT NULL ," + // 1: mid
                "\"NAME__GUJRATI\" TEXT," + // 2: name_Gujrati
                "\"NAME__HINDI\" TEXT," + // 3: name_Hindi
                "\"NAME__ENGLISH\" TEXT," + // 4: name_English
                "\"DISCRIPTION__GUJRATI\" TEXT," + // 5: discription_Gujrati
                "\"DISCRIPTION__HINDI\" TEXT," + // 6: discription_Hindi
                "\"DISCRIPTION__ENGLISH\" TEXT," + // 7: discription_English
                "\"IMAGE\" TEXT);"); // 8: image
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SUBMENU\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Submenu entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getMid());
 
        String name_Gujrati = entity.getName_Gujrati();
        if (name_Gujrati != null) {
            stmt.bindString(3, name_Gujrati);
        }
 
        String name_Hindi = entity.getName_Hindi();
        if (name_Hindi != null) {
            stmt.bindString(4, name_Hindi);
        }
 
        String name_English = entity.getName_English();
        if (name_English != null) {
            stmt.bindString(5, name_English);
        }
 
        String discription_Gujrati = entity.getDiscription_Gujrati();
        if (discription_Gujrati != null) {
            stmt.bindString(6, discription_Gujrati);
        }
 
        String discription_Hindi = entity.getDiscription_Hindi();
        if (discription_Hindi != null) {
            stmt.bindString(7, discription_Hindi);
        }
 
        String discription_English = entity.getDiscription_English();
        if (discription_English != null) {
            stmt.bindString(8, discription_English);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(9, image);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Submenu entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getMid());
 
        String name_Gujrati = entity.getName_Gujrati();
        if (name_Gujrati != null) {
            stmt.bindString(3, name_Gujrati);
        }
 
        String name_Hindi = entity.getName_Hindi();
        if (name_Hindi != null) {
            stmt.bindString(4, name_Hindi);
        }
 
        String name_English = entity.getName_English();
        if (name_English != null) {
            stmt.bindString(5, name_English);
        }
 
        String discription_Gujrati = entity.getDiscription_Gujrati();
        if (discription_Gujrati != null) {
            stmt.bindString(6, discription_Gujrati);
        }
 
        String discription_Hindi = entity.getDiscription_Hindi();
        if (discription_Hindi != null) {
            stmt.bindString(7, discription_Hindi);
        }
 
        String discription_English = entity.getDiscription_English();
        if (discription_English != null) {
            stmt.bindString(8, discription_English);
        }
 
        String image = entity.getImage();
        if (image != null) {
            stmt.bindString(9, image);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Submenu readEntity(Cursor cursor, int offset) {
        Submenu entity = new Submenu( //
            cursor.getInt(offset + 0), // id
            cursor.getInt(offset + 1), // mid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name_Gujrati
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name_Hindi
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // name_English
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // discription_Gujrati
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // discription_Hindi
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // discription_English
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // image
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Submenu entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setMid(cursor.getInt(offset + 1));
        entity.setName_Gujrati(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName_Hindi(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setName_English(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDiscription_Gujrati(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDiscription_Hindi(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDiscription_English(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setImage(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Submenu entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Submenu entity) {
        return null;
    }

    @Override
    public boolean hasKey(Submenu entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}