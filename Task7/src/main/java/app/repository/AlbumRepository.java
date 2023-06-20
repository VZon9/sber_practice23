package app.repository;

import app.dto.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByGroupId(long groupId);

    Album findByGroupIdAndId(long groupId, long albumId);
}
