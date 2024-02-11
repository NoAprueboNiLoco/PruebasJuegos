using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NewBehaviourScript : MonoBehaviour
{
    private float x;
    private float z;
    public CharacterController player;
    private Vector3 playerInput;
    private Vector3 movePlayer;
    public float playerSpeed = 8f;
    public Camera mainCamera;
    public Vector3 camForward;
    public Vector3 camRight;


    // Start is called before the first frame update
    private void Start() {
        player = GetComponent<CharacterController>();
    }

    // Update is called once per frame
    private void Update() {
        x = Input.GetAxis("Horizontal");
        z = Input.GetAxis("Vertical");

        playerInput = Vector3.ClampMagnitude(new Vector3(x,0,z),1);

        camDirection();

        movePlayer = playerInput.x * camRight + playerInput.z * camForward;

        player.transform.LookAt(player.transform.position + movePlayer);
        player.Move(movePlayer * playerSpeed*Time.deltaTime);
        Debug.Log("camRight: " + camRight);

    }

    void camDirection(){
        camForward = mainCamera.transform.forward;
        camRight = mainCamera.transform.right;

        camForward.y = 0;
        camRight.y = 0;

        camForward = camForward.normalized;
        camRight = camRight.normalized;
    }
}
