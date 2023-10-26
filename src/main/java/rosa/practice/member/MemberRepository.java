package rosa.practice.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long MemberId);
}
