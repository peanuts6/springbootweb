package xqy.msa.springbootweb.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;

    private String roleName;

    private String roleDesc;
}