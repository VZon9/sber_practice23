package app.repository;

import app.dto.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByGroupIdAndAlbumId(long groupId, long albumId);

    Song findByGroupIdAndAlbumIdAndId(long groupId, long albumId, long id);
}
