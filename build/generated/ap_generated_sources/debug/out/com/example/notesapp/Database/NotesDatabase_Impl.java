package com.example.notesapp.Database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.notesapp.Dao.NotesDao;
import com.example.notesapp.Dao.NotesDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotesDatabase_Impl extends NotesDatabase {
  private volatile NotesDao _notesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `notes_database` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `notes_title` TEXT, `notes_subtitle` TEXT, `notes_date` TEXT, `note` TEXT, `notes_priority` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f0f88a6de1451d649f1f5716dfcbee48')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `notes_database`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsNotesDatabase = new HashMap<String, TableInfo.Column>(6);
        _columnsNotesDatabase.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotesDatabase.put("notes_title", new TableInfo.Column("notes_title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotesDatabase.put("notes_subtitle", new TableInfo.Column("notes_subtitle", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotesDatabase.put("notes_date", new TableInfo.Column("notes_date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotesDatabase.put("note", new TableInfo.Column("note", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotesDatabase.put("notes_priority", new TableInfo.Column("notes_priority", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotesDatabase = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotesDatabase = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotesDatabase = new TableInfo("notes_database", _columnsNotesDatabase, _foreignKeysNotesDatabase, _indicesNotesDatabase);
        final TableInfo _existingNotesDatabase = TableInfo.read(_db, "notes_database");
        if (! _infoNotesDatabase.equals(_existingNotesDatabase)) {
          return new RoomOpenHelper.ValidationResult(false, "notes_database(com.example.notesapp.Model.Notes).\n"
                  + " Expected:\n" + _infoNotesDatabase + "\n"
                  + " Found:\n" + _existingNotesDatabase);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f0f88a6de1451d649f1f5716dfcbee48", "befbc6630ba653d2eb60d99d3655f822");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "notes_database");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `notes_database`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(NotesDao.class, NotesDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public NotesDao notesDao() {
    if (_notesDao != null) {
      return _notesDao;
    } else {
      synchronized(this) {
        if(_notesDao == null) {
          _notesDao = new NotesDao_Impl(this);
        }
        return _notesDao;
      }
    }
  }
}
