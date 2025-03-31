package com.chrzanop.coding.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SimplifyPathTest {

    @Test
    void test() {
        String complexPath =  "/../abc//./foo/";

        SimplifyPath simplifyPath = new SimplifyPath();
        String simplifiedPath = simplifyPath.simplifyPath(complexPath);

        assertThat(simplifiedPath).isEqualTo("/abc/foo");

    }

    @Test
    void test2() {
        String complexPath =  "/abc/def//./../";

        SimplifyPath simplifyPath = new SimplifyPath();
        String simplifiedPath = simplifyPath.simplifyPath(complexPath);

        assertThat(simplifiedPath).isEqualTo("/abc");

    }

}