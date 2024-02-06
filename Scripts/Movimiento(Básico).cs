using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NewBehaviourScript : MonoBehaviour
{
    public float horizontalMove;
    public float verticalMove;
    public CharacterController player;
    public float playerSpeed = 0.2f;

    // Start is called before the first frame update
    private void Start() {
        player = GetComponent<CharacterController>();
    }

    // Update is called once per frame
    private void Update() {
        horizontalMove = Input.GetAxis("Horizontal");
        verticalMove = Input.GetAxis("Vertical");
    }

    private void FixedUpdate() {
        player.Move(new Vector3(horizontalMove,0,verticalMove)*playerSpeed);
    }

}
