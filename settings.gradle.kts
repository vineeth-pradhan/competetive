/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.7/userguide/multi_project_builds.html in the Gradle documentation.
 */

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0";
    id("com.gradle.develocity") version "3.17.1"

}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/help/legal-terms-of-use"
        termsOfUseAgree = "yes"
    }
}
rootProject.name = "competetive-java"
include("TwoSum")
// // include("Problem915E")
// include("PrimeGenerator")
include("AddTwoLinkedListNumbers")
include("IntegerToRoman")
include("BinaryTreeInorderTraversal")
include("RemoveSomeDuplicates")
include("RotateImage")
include("FindRotation")
include("ReverseLinkedList")
include("AddToArrayForm")
include("RemoveElement")
include("RemoveLinkedListElements")
include("DeleteNodeInALinkedList")
include("DeleteMiddleNodeOfALinkedList")
include("MoveZeroes")
include("MiddleOfTheLinkedList")
