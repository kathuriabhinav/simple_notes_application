package com.example.notesapp.Dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.notesapp.Model.Notes;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotesDao_Impl implements NotesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Notes> __insertionAdapterOfNotes;

  private final EntityDeletionOrUpdateAdapter<Notes> __updateAdapterOfNotes;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNotes;

  public NotesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotes = new EntityInsertionAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `notes_database` (`id`,`notes_title`,`notes_subtitle`,`notes_date`,`note`,`notes_priority`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        stmt.bindLong(1, value.id);
        if (value.notes_title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.notes_title);
        }
        if (value.notes_subtitle == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.notes_subtitle);
        }
        if (value.notes_date == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.notes_date);
        }
        if (value.note == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.note);
        }
        if (value.notes_priority == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.notes_priority);
        }
      }
    };
    this.__updateAdapterOfNotes = new EntityDeletionOrUpdateAdapter<Notes>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `notes_database` SET `id` = ?,`notes_title` = ?,`notes_subtitle` = ?,`notes_date` = ?,`note` = ?,`notes_priority` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Notes value) {
        stmt.bindLong(1, value.id);
        if (value.notes_title == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.notes_title);
        }
        if (value.notes_subtitle == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.notes_subtitle);
        }
        if (value.notes_date == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.notes_date);
        }
        if (value.note == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.note);
        }
        if (value.notes_priority == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.notes_priority);
        }
        stmt.bindLong(7, value.id);
      }
    };
    this.__preparedStmtOfDeleteNotes = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM notes_database WHERE id=?";
        return _query;
      }
    };
  }

  @Override
  public void insertNotes(final Notes... notes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNotes.insert(notes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateNotes(final Notes notes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNotes.handle(notes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteNotes(final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNotes.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteNotes.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Notes>> getallNotes() {
    final String _sql = "SELECT * FROM notes_database";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"notes_database"}, false, new Callable<List<Notes>>() {
      @Override
      public List<Notes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNotesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_title");
          final int _cursorIndexOfNotesSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_subtitle");
          final int _cursorIndexOfNotesDate = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_date");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfNotesPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_priority");
          final List<Notes> _result = new ArrayList<Notes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Notes _item;
            _item = new Notes();
            _item.id = _cursor.getInt(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfNotesTitle)) {
              _item.notes_title = null;
            } else {
              _item.notes_title = _cursor.getString(_cursorIndexOfNotesTitle);
            }
            if (_cursor.isNull(_cursorIndexOfNotesSubtitle)) {
              _item.notes_subtitle = null;
            } else {
              _item.notes_subtitle = _cursor.getString(_cursorIndexOfNotesSubtitle);
            }
            if (_cursor.isNull(_cursorIndexOfNotesDate)) {
              _item.notes_date = null;
            } else {
              _item.notes_date = _cursor.getString(_cursorIndexOfNotesDate);
            }
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _item.note = null;
            } else {
              _item.note = _cursor.getString(_cursorIndexOfNote);
            }
            if (_cursor.isNull(_cursorIndexOfNotesPriority)) {
              _item.notes_priority = null;
            } else {
              _item.notes_priority = _cursor.getString(_cursorIndexOfNotesPriority);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Notes>> getallNoteshightolow() {
    final String _sql = "SELECT * FROM notes_database ORDER BY notes_priority DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"notes_database"}, false, new Callable<List<Notes>>() {
      @Override
      public List<Notes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNotesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_title");
          final int _cursorIndexOfNotesSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_subtitle");
          final int _cursorIndexOfNotesDate = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_date");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfNotesPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_priority");
          final List<Notes> _result = new ArrayList<Notes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Notes _item;
            _item = new Notes();
            _item.id = _cursor.getInt(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfNotesTitle)) {
              _item.notes_title = null;
            } else {
              _item.notes_title = _cursor.getString(_cursorIndexOfNotesTitle);
            }
            if (_cursor.isNull(_cursorIndexOfNotesSubtitle)) {
              _item.notes_subtitle = null;
            } else {
              _item.notes_subtitle = _cursor.getString(_cursorIndexOfNotesSubtitle);
            }
            if (_cursor.isNull(_cursorIndexOfNotesDate)) {
              _item.notes_date = null;
            } else {
              _item.notes_date = _cursor.getString(_cursorIndexOfNotesDate);
            }
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _item.note = null;
            } else {
              _item.note = _cursor.getString(_cursorIndexOfNote);
            }
            if (_cursor.isNull(_cursorIndexOfNotesPriority)) {
              _item.notes_priority = null;
            } else {
              _item.notes_priority = _cursor.getString(_cursorIndexOfNotesPriority);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Notes>> getallNoteslowtohigh() {
    final String _sql = "SELECT * FROM notes_database ORDER BY notes_priority ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"notes_database"}, false, new Callable<List<Notes>>() {
      @Override
      public List<Notes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNotesTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_title");
          final int _cursorIndexOfNotesSubtitle = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_subtitle");
          final int _cursorIndexOfNotesDate = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_date");
          final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(_cursor, "note");
          final int _cursorIndexOfNotesPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "notes_priority");
          final List<Notes> _result = new ArrayList<Notes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Notes _item;
            _item = new Notes();
            _item.id = _cursor.getInt(_cursorIndexOfId);
            if (_cursor.isNull(_cursorIndexOfNotesTitle)) {
              _item.notes_title = null;
            } else {
              _item.notes_title = _cursor.getString(_cursorIndexOfNotesTitle);
            }
            if (_cursor.isNull(_cursorIndexOfNotesSubtitle)) {
              _item.notes_subtitle = null;
            } else {
              _item.notes_subtitle = _cursor.getString(_cursorIndexOfNotesSubtitle);
            }
            if (_cursor.isNull(_cursorIndexOfNotesDate)) {
              _item.notes_date = null;
            } else {
              _item.notes_date = _cursor.getString(_cursorIndexOfNotesDate);
            }
            if (_cursor.isNull(_cursorIndexOfNote)) {
              _item.note = null;
            } else {
              _item.note = _cursor.getString(_cursorIndexOfNote);
            }
            if (_cursor.isNull(_cursorIndexOfNotesPriority)) {
              _item.notes_priority = null;
            } else {
              _item.notes_priority = _cursor.getString(_cursorIndexOfNotesPriority);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
